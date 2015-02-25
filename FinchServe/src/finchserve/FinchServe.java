package finchserve;

import edu.cmu.ri.createlab.terk.robot.finch.Finch;
import java.util.logging.Level;
import java.util.logging.Logger;


public class FinchServe {
    
TestDisplay display;
Finch finch_1;
Finch finch_2;
Finch[] finchArray;

public FinchServe(){
//CommTool tool = new CommTool();
finch_1 = new Finch();
    signalFinch(finch_1, 1);
    finch_2 = new Finch();
    signalFinch(finch_2, 2);

finchArray = new Finch[]{finch_1,finch_2};
//signalFinch(finchArray[0],1);
//signalFinch(finchArray[1],2);
//finch_1.setWheelVelocities(200, 200);
//finch_2.setWheelVelocities(200, 200);

display = new TestDisplay();

runtest();
}
    private void runtest() {
double[] values = new double[3];
int cycle = 10;
double AX,AY,AZ;
        while (true) {
            AX = 0;
            AY = 0;
            AZ = 0;
            values[0]= 0;
            values[1] = 0;
            values[2] = 0;
            
            try {
        Thread.sleep(200);
    } catch (InterruptedException ex) {
        System.out.println(ex.getMessage());
       System.exit(-1);
    }
            
            for (int i = 0; i < cycle; i++) {
                AX+= finch_1.getXAcceleration();
                AY+= finch_1.getYAcceleration();
                AZ+= finch_1.getZAcceleration();
            }
            
            AX /= cycle;
            AY /= cycle;
            AZ /= cycle;
            
            if(AX>=0){
                AX = AX*225.33;
                    if (AX < 70) {
                     AX = 0;
                     }
         
            }else{
            //AX = AX*312.5;
             AX = AX*350.5;
            
            if (AX > -70) {
                     AX = 0;
                     }
            
            }
           values[0] = Math.floor(AX);
           
            if (values[0]>=253) {
                values[0]=253;
            }
            
            if (values[0]<=-253) {
                values[0]=-253;
            }
            int speed = (int)values[0];
//            double pitch = Math.atan((AX/Math.sqrt(Math.pow(AY,2)))+(Math.pow(AZ,2)));
//            double roll = Math.atan((AY/Math.sqrt(Math.pow(AX,2)))+(Math.pow(AZ,2)));
//            
//            pitch = pitch * (180.0/Math.PI);
//            roll = roll * (180.0/Math.PI) ;
            
            //values[0]= AX;
            values[1] = AY;
            values[2] = AZ;
            display.setAccelValues(values);
            finch_2.setWheelVelocities(speed,speed);
        }
        
    }
    
    private void signalFinch(Finch finch,int num){
        for (int i = 0; i < num; i++) {
    finch.setLED(255, 0, 0, 400);
    finch.setLED(0, 255, 0, 400);
    finch.setLED(0, 0, 255, 400);
    finch.sleep(500);
        }
    }
    
    
    public static void main(String[] args) {
        FinchServe app = new FinchServe();
    }



}
