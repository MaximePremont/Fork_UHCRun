package net.samagames.uhcrun.listener;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.inventory.CraftingInventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

/**
 * This file is a part of the SamaGames Project CodeBase
 * This code is absolutely confidential.
 * Created by Thog
 * (C) Copyright Elydra Network 2014 & 2015
 * All rights reserved.
 */
public class CraftListener implements Listener
{

    private List<String> diamondDesc;

    public CraftListener()
    {
        diamondDesc = new ArrayList<>();
        diamondDesc.add(ChatColor.GRAY + "Aperture™ Uncrafted Companion Diamond");
        diamondDesc.add(ChatColor.GRAY + "© Aperture Science - All rights reserved");
    }

    @EventHandler
    public void onCraft(CraftItemEvent event)
    {
        this.onCraft(event.getRecipe(), event.getInventory());
    }

    @EventHandler
    public void onCraft(PrepareItemCraftEvent event)
    {
        this.onCraft(event.getRecipe(), event.getInventory());
    }

    private void onCraft(Recipe recipe, CraftingInventory inventory)
    {
        if ((recipe.getResult().getType() == Material.GOLDEN_APPLE && recipe.getResult().getDurability() == 1) || (recipe.getResult().getType() == Material.FLINT_AND_STEEL) || (recipe.getResult().getType() == Material.BEACON))
        {
            inventory.setResult(new ItemStack(Material.AIR));
        } else if (recipe.getResult().getType() == Material.WOOD_SWORD)
        {
            inventory.setResult(new ItemStack(Material.STONE_SWORD));
        } else if (recipe.getResult().getType() == Material.WOOD_PICKAXE)
        {
            inventory.setResult(new ItemStack(Material.STONE_PICKAXE));
        } else if (recipe.getResult().getType() == Material.WOOD_AXE)
        {
            inventory.setResult(new ItemStack(Material.STONE_AXE));
        } else if (recipe.getResult().getType() == Material.WOOD_SPADE)
        {
            inventory.setResult(new ItemStack(Material.STONE_SPADE));
        } else if (recipe.getResult().getType() == Material.DIAMOND)
        {
            ItemStack res = inventory.getResult();
            ItemMeta meta = res.getItemMeta();
            meta.setLore(diamondDesc);
            res.setItemMeta(meta);
            inventory.setResult(res);
        }
    }
}
