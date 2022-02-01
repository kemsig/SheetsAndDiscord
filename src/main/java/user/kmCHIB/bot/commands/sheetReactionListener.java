package user.kmCHIB.bot.commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import user.kmCHIB.bot.misc.heldData;
import user.kmCHIB.bot.misc.randomID;

import java.awt.*;
import java.util.EnumSet;
import java.util.concurrent.atomic.AtomicReference;

public class sheetReactionListener extends ListenerAdapter {
    @Override
    public void onMessageReactionAdd(MessageReactionAddEvent e) {
        heldData hd = new heldData("src/main/resources/data");
        heldData ud = new heldData("src/main/resources/userdata");
        randomID id = new randomID();
        //if (hd.searchHDataByName("setupmessageid").equals("" + 0)) hd.updateData("setupmessageid", "" + e.getMessageIdLong());
        System.out.println("reacted message: " + e.getMessageIdLong());

        if (e.getReactionEmote().getName().equals("✅") && e.getChannel().getIdLong() == Long.parseLong(hd.searchHDataByName("setupmessageid"))
         && !e.getMember().getUser().equals(e.getJDA().getSelfUser()) ){
            String randomID = "" + id.getRand();

            //log the user and set their channel, if they already have one their main channel will be deleted
            String UUID = e.getUserId();
            System.out.println("UUID " + UUID);
            if (ud.searchHDataByName(UUID) == null){ ud.createData(UUID, randomID);}
            else{
                //delete old channel
                e.getGuild().getTextChannelsByName(ud.searchHDataByName(UUID), false).get(0).delete().queue();

                //set a new
                randomID = "" + id.getRand();
                ud.updateData(UUID, randomID);
            }
            System.out.println("mainMessageID");

            //messages
            EmbedBuilder welcome = new EmbedBuilder();
            welcome.setColor(Color.CYAN).setTitle("Please Input Two Sheet ID's - Sheets IO")
                    .setDescription("Start by typing two sheet ID's and select what type. (Main or Attended)")
                    .setFooter("Press \'✅\' when completed or \'❌\' to abort.");

            //create a new channel and send a message

            e.getGuild().getCategoryById(Long.parseLong(hd.searchHDataByName("categoryid"))).createTextChannel(randomID)
                    .addPermissionOverride(e.getGuild().getPublicRole(), null, EnumSet.of(Permission.VIEW_CHANNEL))
                    .addMemberPermissionOverride(e.getMember().getUser().getIdLong(), EnumSet.of(Permission.VIEW_CHANNEL), null)
                    .queue(message -> {
                        message.sendMessageEmbeds(welcome.build())
                                .queue(reactions -> {
                                    if (ud.searchHDataByName("m1_" + e.getUserId()) == null)
                                        ud.createData("m1_" + e.getUserId(), reactions.getId());
                                    else
                                        ud.updateData("m1_" + e.getUserId(), reactions.getId());
                                    reactions.addReaction("✅").queue();
                                    reactions.addReaction("❌").queue();
                                });
                    });
            System.out.println("message: " + ud.searchHDataByName("m1_" + e.getUserId()));
            /*
            .flatMap(result -> result.sendMessageEmbeds(welcome.build())
                            .flatMap(message -> {
                                System.out.println(message.getIdLong());
                                return message.addReaction("✅");
                            }))
                    .queue();
             */
        }

    }
}
