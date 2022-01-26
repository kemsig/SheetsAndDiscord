package user.kmCHIB.bot.commands;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import user.kmCHIB.bot.Sheets.SheetsQuickstart;

import java.io.IOException;
import java.security.GeneralSecurityException;

public class testSheetsListener extends ListenerAdapter {
    public void onMessageReceived(MessageReceivedEvent e){
        if (e.getAuthor().isBot()) return;
        String message = e.getMessage().getContentRaw();
        if (message.equalsIgnoreCase("!quickstart")){
            SheetsQuickstart sq = new SheetsQuickstart();
            try {
                sq.quickStart();
            } catch (IOException ex) {
                ex.printStackTrace();
            } catch (GeneralSecurityException ex) {
                ex.printStackTrace();
            }
            sq.printValues();
        }
    }

}
