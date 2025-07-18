package io.github.kosmx.emotes.main.sources;

import io.github.kosmx.emotes.main.EmoteHolder;
import io.github.kosmx.emotes.mc.McUtils;
import io.github.kosmx.emotes.server.serializer.EmoteSerializer;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;

import java.util.List;

public record FileEmoteSource(EmoteHolder holder) implements EmoteSource {
    private static final Component BUILT_IN = Component.translatable("emotecraft.emotesource.builtin");

    private static final ResourceLocation ICON = McUtils.newIdentifier("123"); // TODO

    @Override
    public ResourceLocation icon() {
        return FileEmoteSource.ICON;
    }

    @Override
    public Component tooltip() {
        if (this.holder.emote.data().has(EmoteSerializer.BUILTIN_KEY)) {
            return FileEmoteSource.BUILT_IN;
        }

        MutableComponent path = Component.empty().append(McUtils.SLASH);

        List<Component> folderPath = this.holder.folder;
        for (int i = 0; i < folderPath.size(); i++) {
            path = path.append(CommonComponents.SPACE).append(folderPath.get(i));

            if (i < folderPath.size() - 1) {
                path = path.append(CommonComponents.SPACE).append(McUtils.SLASH);
            }
        }

        if (this.holder.fileName != null) {
            path = path.append(CommonComponents.SPACE);

            if (!this.holder.folder.isEmpty()) {
                path = path.append(McUtils.SLASH);
            }

            path = path.append(this.holder.fileName);
        }

        return Component.translatable("emotecraft.emotesource.folder", path);
    }
}
