package user.kmCHIB.bot.commands;

import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class sheetReactionListener extends ListenerAdapter {
    @Override
    public void onMessageReactionAdd(MessageReactionAddEvent e) {
        if (e.getReactionEmote().getName().equals("✅") /*&& e.getMessageIdLong() == setupMessageID */
         && !e.getMember().getUser().equals(e.getJDA().getSelfUser())){
            e.getGuild().getCategoryById(936163667756613712L).createTextChannel("sheet-233241").queue();
            e.getGuild().getMemberById(e.getJDA().getSelfUser().getIdLong()).getPermissions().add(Permission.MANAGE_CHANNEL);
            System.out.println("donev2");
        }
    }
}
