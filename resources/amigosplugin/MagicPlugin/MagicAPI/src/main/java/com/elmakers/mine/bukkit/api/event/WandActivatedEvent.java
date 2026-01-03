package com.elmakers.mine.bukkit.api.event;

import javax.annotation.Nonnull;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import com.elmakers.mine.bukkit.api.magic.Mage;
import com.elmakers.mine.bukkit.api.wand.Wand;

/**
 * A custom event that the Magic plugin will fire whenever a wand has become
 * activated.
 */
public class WandActivatedEvent extends Event {
    private final @Nonnull Mage mage;
    private final @Nonnull Wand wand;

    private static final HandlerList handlers = new HandlerList();

    public WandActivatedEvent(@Nonnull Mage mage, @Nonnull Wand wand) {
        this.mage = mage;
        this.wand = wand;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

    @Nonnull
    public Mage getMage() {
        return mage;
    }

    @Nonnull
    public Wand getWand() {
        return wand;
    }
}
