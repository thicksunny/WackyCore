package tristan.core;

import org.bukkit.plugin.java.JavaPlugin;
import tristan.core.cmds.CmdMgr;
import tristan.core.events.EventMgr;
import tristan.core.session.SessionManager;
import tristan.core.utils.RankUtil;

public final class Core extends JavaPlugin{

    public static Core instance;

    private final CmdMgr cmdMgr = new CmdMgr(this);
    private final EventMgr eventMgr = new EventMgr(this);
    private SessionManager sessionMgr = new SessionManager(this);

    @Override
    public void onEnable(){
        instance = this;
        saveDefaultConfig();
        cmdMgr.registerCmds();
        eventMgr.registerEvents();
        sessionMgr = new SessionManager(this);
        getDataFolder().mkdirs();
        RankUtil.loadRanksFromConfig(this);
    }

    @Override
    public void onDisable(){
        saveConfig();
    }

    public static Core getInstance(){
        return instance;
    }

}
