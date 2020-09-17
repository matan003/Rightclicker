package haven.plugins;

import haven.*;
import java.util.Collection;
import java.util.Iterator;

public class MarioPlugin extends Plugin{
    public void load(UI ui)
    {
        Glob glob = ui.sess.glob;
        Collection<Glob.Pagina> p = glob.paginae;
        p.add(glob.paginafor(Resource.load("paginae/add/hello")));
        XTendedPaginae.registerPlugin("Mario",this);
    }
    
    public void execute(final UI ui){
        ui.message("Korv", GameUI.MsgType.INFO);
        
        new Thread(new Runnable(){
            @Override
            public void run(){
                perform_rightclick(ui);
            }
        },"Rightclicker").start();
    }
    
    public void perform_rightclick(UI ui){
        if(ui.gui.hand.isEmpty()){
            ui.message("[Korv] Kan inte högerklicka om du inte har det på muspekaren", GameUI.MsgType.INFO);
            return;
        }
        
        Iterator<GItem> handContent = ui.gui.hand.iterator();
        
    }
}
