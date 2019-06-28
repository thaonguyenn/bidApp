package org.webproject.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.webproject.model.BidSessions;

@Service
@Component
@Scope("prototype")
public class RunningClock implements Runnable{
	@Autowired
	BidSessionsService bidSessionsService;
	
	@Override
	public void run() {
		while(true) {
			//set status -- ajax in jsp will show time base on this status
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date = new Date();
			List<BidSessions> listSession = bidSessionsService.getListNotReadySession();
			for (BidSessions bidSessions : listSession) {
				long diff = bidSessions.getBidTime().getTime() - date.getTime();
				long diffMinutes = diff / (60 * 1000) % 60;
				long diffHours = diff / (60 * 60 * 1000) % 24;
				long diffDays = diff / (24 * 60 * 60 * 1000);
				if(diffDays == 0 && diffHours == 0 && diffMinutes <= 30) {
					bidSessionsService.updateStatus(bidSessions.getSessionID(), 2);
				}
			}
			String timeSession = ""; 
			List<BidSessions> listReadySession = bidSessionsService.getListReadySession();
			for (BidSessions bidSessions : listReadySession) {
				String timeNow = dateFormat.format(date);
				timeSession = dateFormat.format(bidSessions.getBidTime());
				if (timeNow.equals(timeSession)) {
					bidSessionsService.updateStatus(bidSessions.getSessionID(), 3);
				}
			}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		}
		
	}
	
	
}
