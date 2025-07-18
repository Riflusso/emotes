package io.github.kosmx.emotes.main.sources;

import io.github.kosmx.emotes.mc.McUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

public record PlainEmoteSource(ResourceLocation icon, Component tooltip) implements EmoteSource {
    public static final PlainEmoteSource UNKNOWN_SOURCE = new PlainEmoteSource(
            McUtils.newIdentifier("123"), // TODO
            Component.translatable("emotecraft.emotesource.unknown")
    );
}
