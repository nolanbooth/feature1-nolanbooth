package org.jointheleague.features.student.first_feature;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.jointheleague.api_wrapper.ReceivedMessage;
import org.jointheleague.features.abstract_classes.Feature;
import org.jointheleague.features.help_embed.plain_old_java_objects.help_embed.HelpEmbed;
	



	public class BetterCurrentTime extends Feature {

		public final String COMMAND = "!currentTime";

		public BetterCurrentTime(String channelName) {
			super(channelName);
			helpEmbed = new HelpEmbed(COMMAND, "Displays the current time");
		}

		@Override
		public void handle(ReceivedMessage event) {
			String messageContent = event.getMessageContent();
			if (messageContent.startsWith(COMMAND)) {
				Date date = new Date(System.currentTimeMillis()+10);
				SimpleDateFormat formatter = new SimpleDateFormat("'The time is 'HH:mm:ss z' on 'MM-dd-yyyy'.'");
				event.sendResponse(formatter.format(date));
			}
		}
	}


