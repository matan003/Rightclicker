package haven.plugins;

import haven.*;
import java.util.Collection;

public class MyFirstPlugin extends Plugin{
    public void load(UI ui)
    {
        Glob glob = ui.sess.glob;
        Collection<Glob.Pagina> p = glob.paginae;
        p.add(glob.paginafor(Resource.load("paginae/add/hello")));
        XTendedPaginae.registerPlugin("hello",this);
    }
    
    public void execute(UI ui){
        ui.message("[MyFirstPlugin] Succesfully executed my first plugin!", GameUI.MsgType.INFO);
    }
}
