package ba.unsa.etf.rpr.tutorijal02;

public class Interval
{
    double pt;
    double kt;
    boolean pripada1;
    boolean pripada2;

    public Interval(double apt, double akt, boolean apripada1, boolean apripada2) throws IllegalArgumentException{
        if (apt > akt) {throw new IllegalArgumentException("Greska");}
        pt=apt; kt=akt; pripada1=apripada1; pripada2=apripada2;
    }

    public Interval()
    {
        pt = 0;
        kt = 0;
        pripada1 = false;
        pripada2 = false;
    }

    public boolean isNull()
    {
        if (pt - kt == 0)
        {
            return true;
        }
        return false;
    }

    public boolean isIn(double t)
    {
        if (pripada1 == true && pripada2 == true)
        {
            if ((pt < t && kt > t) || t == pt || t == kt)
            {
                return true;
            }
        } else if (pripada1 == true && pripada2 == false)
        {
            if ((pt < t && kt > t) || t == pt)
            {
                return true;
            }
        } else if (pripada1 == false && pripada2 == false)
        {
            if (pt < t && kt > t)
            {
                return true;
            }
        }
        return false;
    }

    public Interval intersect(Interval a)
    {
        if (pripada1 == true && pripada2 == true && a.pripada1 == true && a.pripada2 == true)
        {
            if(pt<=a.pt && kt>=a.kt){return a;}
            else if(a.pt<=pt && a.kt>=kt){a.pt=pt; a.kt=kt; return a;}
            else if(pt<=a.pt && a.kt>=kt){a.kt=kt; return a; }
            else if(a.pt<=pt && kt>=a.kt){a.pt=pt; return a;}

        }else if(pripada1 == false && pripada2 == true && a.pripada1 == true && a.pripada2 == true){
            if(pt<=a.pt && kt>=a.kt){return a;}
            else if(a.pt<pt && a.kt>=kt){a.pt=pt; a.pripada1=false; a.kt=kt; return a;}
            else if(pt<=a.pt && a.kt>=kt){a.kt=kt; return a; }
            else if(a.pt<pt && kt>=a.kt){a.pt=pt; a.pripada1=false; return a;}
            else if(a.pt==pt && a.kt>=kt){a.pt=pt; a.kt=kt; return a;}
            else if(a.pt==pt && kt>=a.kt){a.pt=pt;  return a;}

        }else if(pripada1 == true && pripada2 == true && a.pripada1 == false && a.pripada2 == true){
            if(pt<a.pt && kt>=a.kt){return a;}
            else if(a.pt<=pt && a.kt>=kt){a.pt=pt; a.kt=kt; return a;}
            else if(pt<a.pt && a.kt>=kt){a.kt=kt; return a; }
            else if(a.pt<=pt && kt>=a.kt){a.pt=pt; return a;}
            else if(a.pt==pt && a.kt>=kt){a.pt=pt; a.pripada1 =true; a.kt=kt; return a;}
            else if(a.pt==pt && kt>=a.kt){a.pt=pt; a.pripada1=true; return a;}

        }
        else if(pripada1 == true && pripada2 == false && a.pripada1 == true && a.pripada2 == true){
            if(pt<=a.pt && kt>=a.kt){return a;}
            else if(a.pt<=pt && a.kt>kt){a.pt=pt; a.kt=kt; a.pripada2=false;return a;}
            else if(pt<=a.pt && a.kt>kt){a.kt=kt; a.pripada2=false; return a; }
            else if(a.pt<=pt && kt>=a.kt){a.pt=pt; return a;}
            else if(a.pt<=pt && a.kt==kt){a.pt=pt; a.kt=kt;  return a;}
            else if(pt<=a.pt && a.kt==kt){a.kt=kt; return a; }


        }
        else if(pripada1 == true && pripada2 == true && a.pripada1 == true && a.pripada2 == false){

            if(pt<=a.pt && kt>a.kt){return a;}
            else if(a.pt<=pt && a.kt>kt){a.pt=pt; a.kt=kt; a.pripada2=true;return a;}
            else if(pt<=a.pt && a.kt>kt){a.kt=kt; a.pripada2=true; return a; }
            else if(a.pt<=pt && kt>a.kt){a.pt=pt; return a;}
            else if(a.pt<=pt && a.kt==kt){a.pt=pt; a.kt=kt; a.pripada2=true;  return a;}
            else if(pt<=a.pt && a.kt==kt){a.kt=kt; a.pripada2=true; return a; }
        }
        else if(pripada1 == true && pripada2 == false && a.pripada1 == true && a.pripada2 == false){
            if(pt<=a.pt && kt>=a.kt){return a;}
            else if(a.pt<=pt && a.kt>=kt){a.pt=pt; a.kt=kt;return a;}
            else if(pt<=a.pt && a.kt>=kt){a.kt=kt;return a; }
            else if(a.pt<=pt && kt>=a.kt){a.pt=pt; return a;}
        }
        else if(pripada1 == true && pripada2 == false && a.pripada1 == false && a.pripada2 == true){
            if(pt<=a.pt && kt>=a.kt){return a;}
            else if(a.pt<=pt && a.kt>kt){a.pt=pt;a.pripada1=true; a.kt=kt; a.pripada2=false;return a;}
            else if(pt<a.pt && a.kt>=kt){a.kt=kt; return a; }
            else if(a.pt<=pt && kt>a.kt){a.pt=pt; a.pripada1=true; a.pripada2=false;return a;}
            else if(a.pt<=pt && kt==a.kt){a.pt=pt; a.pripada1=true;return a;}
        }
        return a;
}
 public static Interval intersect(Interval b, Interval a){
     if (b.pripada1 == true && b.pripada2 == true && a.pripada1 == true && a.pripada2 == true)
     {
         if(b.pt<=a.pt && b.kt>=a.kt){return a;}
         else if(a.pt<=b.pt && a.kt>=b.kt){a.pt=b.pt; a.kt=b.kt; return a;}
         else if(b.pt<=a.pt && a.kt>=b.kt){a.kt=b.kt; return a; }
         else if(a.pt<=b.pt && b.kt>=a.kt){a.pt=b.pt; return a;}

     }else if(b.pripada1 == false && b.pripada2 == true && a.pripada1 == true && a.pripada2 == true){
         if(b.pt<=a.pt && b.kt>=a.kt){return a;}
         else if(a.pt<b.pt && a.kt>=b.kt){a.pt=b.pt; a.pripada1=false; a.kt=b.kt; return a;}
         else if(b.pt<=a.pt && a.kt>=b.kt){a.kt=b.kt; return a; }
         else if(a.pt<b.pt && b.kt>=a.kt){a.pt=b.pt; a.pripada1=false; return a;}
         else if(a.pt==b.pt && a.kt>=b.kt){a.pt=b.pt; a.kt=b.kt; return a;}
         else if(a.pt==b.pt && b.kt>=a.kt){a.pt=b.pt;  return a;}

     }else if(b.pripada1 == true && b.pripada2 == true && a.pripada1 == false && a.pripada2 == true){
         if(b.pt<a.pt && b.kt>=a.kt){return a;}
         else if(a.pt<=b.pt && a.kt>=b.kt){a.pt=b.pt; a.kt=b.kt; return a;}
         else if(b.pt<a.pt && a.kt>=b.kt){a.kt=b.kt; return a; }
         else if(a.pt<=b.pt && b.kt>=a.kt){a.pt=b.pt; return a;}
         else if(a.pt==b.pt && a.kt>=b.kt){a.pt=b.pt; a.pripada1 =true; a.kt=b.kt; return a;}
         else if(a.pt==b.pt && b.kt>=a.kt){a.pt=b.pt; a.pripada1=true; return a;}

     }
     else if(b.pripada1 == true && b.pripada2 == false && a.pripada1 == true && a.pripada2 == true){
         if(b.pt<=a.pt && b.kt>=a.kt){return a;}
         else if(a.pt<=b.pt && a.kt>b.kt){a.pt=b.pt; a.kt=b.kt; a.pripada2=false;return a;}
         else if(b.pt<=a.pt && a.kt>b.kt){a.kt=b.kt; a.pripada2=false; return a; }
         else if(a.pt<=b.pt && b.kt>=a.kt){a.pt=b.pt; return a;}
         else if(a.pt<=b.pt && a.kt==b.kt){a.pt=b.pt; a.kt=b.kt;  return a;}
         else if(b.pt<=a.pt && a.kt==b.kt){a.kt=b.kt; return a; }


     }
     else if(b.pripada1 == true && b.pripada2 == true && a.pripada1 == true && a.pripada2 == false){

         if(b.pt<=a.pt && b.kt>a.kt){return a;}
         else if(a.pt<=b.pt && a.kt>b.kt){a.pt=b.pt; a.kt=b.kt; a.pripada2=true;return a;}
         else if(b.pt<=a.pt && a.kt>b.kt){a.kt=b.kt; a.pripada2=true; return a; }
         else if(a.pt<=b.pt && b.kt>a.kt){a.pt=b.pt; return a;}
         else if(a.pt<=b.pt && a.kt==b.kt){a.pt=b.pt; a.kt=b.kt; a.pripada2=true;  return a;}
         else if(b.pt<=a.pt && a.kt==b.kt){a.kt=b.kt; a.pripada2=true; return a; }
     }
     else if(b.pripada1 == true && b.pripada2 == false && a.pripada1 == true && a.pripada2 == false){
         if(b.pt<=a.pt && b.kt>=a.kt){return a;}
         else if(a.pt<=b.pt && a.kt>=b.kt){a.pt=b.pt; a.kt=b.kt;return a;}
         else if(b.pt<=a.pt && a.kt>=b.kt){a.kt=b.kt;return a; }
         else if(a.pt<=b.pt && b.kt>=a.kt){a.pt=b.pt; return a;}
     }
     else if(b.pripada1 == true && b.pripada2 == false && a.pripada1 == false && a.pripada2 == true){
         if(b.pt<=a.pt && b.kt>=a.kt){return a;}
         else if(a.pt<=b.pt && a.kt>b.kt){a.pt=b.pt;a.pripada1=true; a.kt=b.kt; a.pripada2=false;return a;}
         else if(b.pt<a.pt && a.kt>=b.kt){a.kt=b.kt; a.pripada2=false; return a; }
         else if(a.pt<=b.pt && b.kt==a.kt){a.pt=b.pt; a.pripada1=true; a.pripada2=true;return a;}

     }
     return a;
 }
 @Override
    public String toString(){
        if(pripada1==false && pripada2==false && pt==0 && kt==0){return "()";}

        if(pripada1==true && pripada2==true){
            return "["+pt+","+kt+"]";
        }else if(pripada1==false && pripada2==true){
            return "("+pt+","+kt+"]";
        }else if(pripada1==true && pripada2==false)
        {
            return "[" + pt + "," + kt + ")";
        }
        return "("+pt+","+kt+")";
 }

 @Override
    public boolean equals(Object a){
        Interval o= (Interval)a;
        if(pt==o.pt && kt==o.kt && pripada1==o.pripada1 && pripada2==o.pripada2){
            return true;
        }
        return false;
 }
}
