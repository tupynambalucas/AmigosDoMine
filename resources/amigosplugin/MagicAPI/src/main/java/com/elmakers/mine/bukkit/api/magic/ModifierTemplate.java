package com.elmakers.mine.bukkit.api.magic;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public interface ModifierTemplate extends MagicProperties {
    @Nonnull
    String getName();
    @Nullable
    String getDescription();
    @Nullable
    String getIconKey();
    @Nullable
    String getIconDisabledKey();
}
