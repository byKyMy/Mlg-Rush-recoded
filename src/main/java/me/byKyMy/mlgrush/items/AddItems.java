package me.byKyMy.mlgrush.items;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class AddItems {

    static ItemStack stick = new ItemStack(Material.STICK);
    static ItemStack pickaxe = new ItemStack(Material.IRON_PICKAXE);
    static ItemStack blocks = new ItemStack(Material.SANDSTONE,  32);


    public static void addItems(){

        for (Player all : Bukkit.getOnlinePlayers()){

            all.getInventory().clear();

            all.sendMessage("§aGame started");

            ItemMeta meta1 = stick.getItemMeta();
            assert meta1 != null;
            meta1.setDisplayName("§5Knockback Stick");
            meta1.addEnchant(Enchantment.KNOCKBACK, 4, false);
            stick.setItemMeta(meta1);
            all.getInventory().setItem(0, stick);

            all.getInventory().setItem(1, pickaxe);

            all.getInventory().setItem(2, blocks);

        }



    }


}
