package user.kmCHIB.bot.commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import user.kmCHIB.bot.Sheets.SheetsQuickstart;
import user.kmCHIB.bot.misc.heldData;

import java.awt.*;
import java.io.IOException;
import java.security.GeneralSecurityException;

public class sheetsSetup extends ListenerAdapter {
    public void onMessageReceived(MessageReceivedEvent e){
        //if (e.getAuthor().isBot()) return;
        heldData hd = new heldData("src/main/resources/data");
        String[] message = e.getMessage().getContentRaw().split(" ");

        //set the current channel into the sheets
        if (message[0].equalsIgnoreCase("!sheetsetup") && !(message[1].isEmpty())
        && e.getAuthor().getIdLong() == e.getGuild().getOwnerIdLong()){
            EmbedBuilder eb = new EmbedBuilder();
            eb.setTitle("Sheets IO").setDescription("React on this message with ✅ to start." ).setColor(Color.CYAN);
            e.getChannel().sendMessageEmbeds(eb.build()).complete().addReaction("✅").queue(); // print setup message and reaction
            hd.updateData("categoryid", "" + e.getGuild().getCategoriesByName(message[1], true).get(0).getIdLong());

            System.out.println("bruh " + e.getChannel().getIdLong());
            hd.updateData("setupmessageid", "" + e.getChannel().getIdLong());
            System.out.println("done");


        }
    }

}
