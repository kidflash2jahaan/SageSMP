package com.systemerr.sagesmp.chatfilter;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import io.papermc.paper.chat.ChatRenderer;
import io.papermc.paper.event.player.AsyncChatEvent;
import net.kyori.adventure.audience.Audience;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;

public class ChatListener implements Listener, ChatRenderer {
    @EventHandler
    public void onChat(AsyncChatEvent event) {
        event.renderer(this);
    }

    @Override
    public Component render(Player source, Component sourceDisplayNameComponent, Component unfilteredComponent, Audience viewerAudience) {
        String unfiltered = "<" + source.getName() + "> " + LegacyComponentSerializer.legacyAmpersand().serialize(unfilteredComponent);
        String filtered = StringFilter.filter(unfiltered);
        Component filteredComponent = LegacyComponentSerializer.legacyAmpersand().deserialize(filtered);

        return filteredComponent;
    }
}