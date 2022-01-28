package user.kmCHIB.bot.commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import user.kmCHIB.bot.Sheets.SheetsQuickstart;
import user.kmCHIB.bot.misc.heldData;

import java.io.IOException;
import java.security.GeneralSecurityException;

public class sheetsSetup extends ListenerAdapter {
    private boolean isSetup;
    private long setupMessageID;
    private String message;

    public void onMessageReceived(MessageReceivedEvent e){
        //if (e.getAuthor().isBot()) return;
        message = e.getMessage().getContentRaw();

        //set the current channel into the sheets
        if (message.equalsIgnoreCase("!sheetsetup") && e.getAuthor().getIdLong() == e.getGuild().getOwnerIdLong()){
            EmbedBuilder eb = new EmbedBuilder();
            eb.setTitle("Sheets IO").setDescription("React on this message with ✅ to start." );
            e.getChannel().sendMessageEmbeds(eb.build()).complete().addReaction("✅").queue(); // print setup message and reaction
            setupEmoteListener sEL = new setupEmoteListener();
            sEL.onMessageReactionAdd();


            setupMessageID = e.getChannel().getLatestMessageIdLong(); //save this for reaction
            System.out.println("done");


        }
    }

}
