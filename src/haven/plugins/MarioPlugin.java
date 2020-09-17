package haven.plugins;

import haven.*;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class MarioPlugin extends Plugin{
    
    public static boolean hasClickedAll = false;
    
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
        
        List<WItem> items = ui.gui.maininv.getSameName("", true);
        
        for(int i = items.size() - 1; i < items.size() && i >= 0; i--){
            WItem subject = items.get(i);
            if(subject.item.resname().contains("") && !hasClickedAll){
                subject.mousedown(Coord.z, 2);
            }
            
            try{
                Thread.sleep(100);
            }catch(InterruptedException ex){
                ui.message("Thread could not sleep!", GameUI.MsgType.BAD);
            }
        }
        
    }
}
