package user.kmCHIB.bot.commands;

import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class sheetReactionListener extends ListenerAdapter {
    @Override
    public void onMessageReactionAdd(MessageReactionAddEvent e) {
        if (e.getReactionEmote().getName().equals("✅") /*&& e.getMessageIdLong() == setupMessageID */
         && !e.getMember().getUser().equals(e.getJDA().getSelfUser())){
            System.out.println("donev2");
        }
    }
}
