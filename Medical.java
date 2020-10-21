
import java.io.*;
import java.util.*;
import java.lang.*;

class drug
{
    public String name;
    int price;
    public int quantity;
    int drugid;

    void getdata()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter drug id\n");
        drugid = sc.nextInt();

        System.out.println("enter drug name\n");
        name = sc.next();

        System.out.println("enter price\n");
        price = sc.nextInt();

        System.out.println("enter quantity\n");
        quantity = sc.nextInt();

    }

    void putdata()
    {
        System.out.println(+drugid  +" \t    "     +name  +"\t\t"        +price    +"\t"       +quantity);
    }
}

public class Medical
{

    public static void main(String args[])
    {
        int no=0;
        int total=0;
        int n=0,i;
        String bill[] = new String[100];
                int quant[] = new int[100];
                int price[] = new int[100];
        int choice1=0,choice=0;
        String s;
        drug o[] = new drug[100];

        Scanner a = new Scanner(System.in);
        while(choice1!=3)
        {
            System.out.println("--------------------------------------");
            System.out.println("Main Menu");
            System.out.println("1.Admin \n2.customer \n3.exit \n");
            System.out.println("--------------------------------------");
            System.out.println("Enter Choice :: ");
                choice1=a.nextInt();
        switch(choice1)
        {
            case 1:
            while(choice!=4)
            {
                System.out.println("--------------------------------------");
                System.out.println("Admin");
                System.out.println("1.ADD drug details \n2.search for drug \n3.display \n4.exit \n");
                System.out.println("--------------------------------------");
                System.out.println("Enter Choice :: ");
                choice=a.nextInt();

                switch(choice)
                {
                 case 1 :
                   System.out.println("how many drug want to enter :-");
                     n = a.nextInt();

                    for(i=0;i<n;i++)
                    {
                    System.out.println("enter the drug info :: "+(i+1));
                    o[i] = new drug();
               
                    }
                     break;
                case 2 :
                   System.out.println("Enter Drug Name :: ");
                    s = a.next();
                    for(i=0;i<n;i++)
                    {
                        if(s.equalsIgnoreCase(o[i].name) && o[i].quantity > 0)
                        {
                            System.out.println("..Drug Available..");
                            break;
                        }
                    }


                    break;
                case 3 :
                    System.out.println("Display all drug");
                    System.out.println("--------------------------------------------");
                    System.out.println("drug id     drugname    price   quantity");
                    for(i=0;i<n;i++)
                    {
                        o[i].putdata();
                    }
                    System.out.println("--------------------------------------------");
                    break;
                case 4 :
                    break;
                }
            }
            choice=0;
            break;
        case 2 :
            while(choice!=3)
            {
                System.out.println(" Customer ");
                System.out.println("--------------------------------------------");
                System.out.println("1.For Generating Bill \n2.Display Bill list \n3.exit");
                System.out.println("--------------------------------------------");
                System.out.println(" Enter Choice :: ");
                choice=a.nextInt();


                switch(choice)
                {
                    case 1:
                        System.out.println("........Bill.........");


                        i=0;
                        System.out.println("Enter No of drugs :: ");
                        no = a.nextInt();
                        int j,quan,count=0;
                        System.out.println("Enter drugs as Drug_name quantity :: ");
                        while(count!=no)
                        {
                            bill[i] = new String();
                            bill[i]=a.next();

                            quant[i] = a.nextInt();
                            for(j=0;j<n;j++)
                            {
                                if(o[j].name.equalsIgnoreCase(bill[i]))
                                {
                                    if(quant[i] <= o[j].quantity  )
                                    {
                                        total = total + o[j].price*quant[i];
                                        o[j].quantity = o[j].quantity - quant[i];
                                    }
                                    else
                                    {
                                        total = total + o[j].price*o[j].quantity;
                                        o[j].quantity = 0;
                                    }
                                    price[i]=o[j].price;
                                     break;
                                }
                            }
                            i++;
                            count++;
                        }
                        System.out.println("::: Bill :::");
                        for(i=0;i<no;i++)
                        {
                            System.out.println(" "+bill[i]+" ");
                        }
                        System.out.println(":::::::::::::::::::::");
                        System.out.println("    Total ::   "+total);
                        break;
                   case 2:
                        System.out.println("Bill List ");

                        String bil[] = new String[100];

                        i=0;


                        System.out.println("::: Bill :::");
                        System.out.println(" Name  Quantity Price Amount");
                        for(i=0;i<no;i++)
                        {
                            System.out.println(" "+bill[i]+"      "+quant[i] + "      "+price[i] + "     " + price[i]*quant[i] );
                        }
                        System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
                        System.out.println("    Total ::   "+total);
                        total=0;
                        no =0;
                        break;
                }
            }
            choice=0;
            break;
        }


    }
        choice1=0;
    }
}
