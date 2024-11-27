package tristan.core.cmds;

import org.bukkit.command.PluginCommand;
import tristan.core.Core;
import tristan.core.cmds.admin.AddItem;
import tristan.core.cmds.inventory.ClearInventory;
import tristan.core.cmds.player.Menu;
import tristan.core.events.MenuListener;

public class CmdMgr{

    private final Core core;

    public CmdMgr(Core core){
        this.core = core;
    }

    public void registerCmds(){
        PluginCommand inv = core.getCommand("clearinventory");
        inv.setExecutor(new ClearInventory(core));
        PluginCommand menu = core.getCommand("menu");
        menu.setExecutor(new Menu(core));
        PluginCommand addItem = core.getCommand("additem");
        addItem.setExecutor(new AddItem());
    }

}
