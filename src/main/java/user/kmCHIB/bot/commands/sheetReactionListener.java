package user.kmCHIB.bot.commands;

import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import user.kmCHIB.bot.misc.heldData;

import java.util.HashMap;

public class sheetReactionListener extends ListenerAdapter {
    @Override
    public void onMessageReactionAdd(MessageReactionAddEvent e) {
        heldData hd = new heldData("src/main/resources/data");
        //if (hd.searchHDataByName("setupmessageid").equals("" + 0)) hd.updateData("setupmessageid", "" + e.getMessageIdLong());
        System.out.println("reacted message: " + e.getMessageIdLong());

        if (e.getReactionEmote().getName().equals("✅") /*&& e.getMessageIdLong() == setupMessageID */
         && !e.getMember().getUser().equals(e.getJDA().getSelfUser()) ){
            //System.out.println(mainMessageID);

        }
    }
}
