package io.github.kosmx.emotes.main.sources;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

public interface EmoteSource {
    ResourceLocation icon();
    Component tooltip();
}
