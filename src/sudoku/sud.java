package sudoku;
class sud
{
 
    int at[][]=new int[9][9];//matrix for storing Sudoku
    int ar[][]=new int[9][9],lr[]=new int[9];//elementsto be filled in the row,limit
    int ac[][]=new int[9][9],lc[]=new int[9];//elementsto be filled in the column,limit
    int ab[][]=new int[9][9],lb[]=new int[9];//elementsto be filled in the box,limit
    int pos[][]=new int[81][9],lm[]=new int[81],mb[]=new int[81],mk;
    int atc[][][][]=new int[89][9][9][9],c[]=new int[81],s[]=new int[81],sp,k,kc;
    int ats[][]=new int[9][9];
    boolean F=true,T;
    long count=0;

 void create()//initialize the Sudoku
 {
    int i,j;
    for(i=0;i<9;++i)
    for(j=0;j<9;++j)
     at[i][j]=0;
           /*
          at[0][0]=1;at[0][1]=2;at[0][2]=3;at[0][3]=4;at[0][4]=5;at[0][5]=6;at[0][6]=7;at[0][7]=8;at[0][8]=9;
          at[1][0]=4;at[1][1]=5;at[1][2]=6;at[1][3]=7;at[1][4]=8;at[1][5]=9;at[1][6]=1;at[1][7]=2;at[1][8]=3;
          at[2][0]=7;at[2][1]=8;at[2][2]=9;at[2][3]=1;at[2][4]=2;at[2][5]=3;at[2][6]=4;at[2][7]=5;at[2][8]=6;
          at[3][0]=2;at[3][1]=1;at[3][2]=4;at[3][3]=3;at[3][4]=6;at[3][5]=5;at[3][6]=8;at[3][7]=9;at[3][8]=7;
          at[4][0]=3;at[4][1]=6;at[4][2]=5;at[4][3]=8;at[4][4]=9;at[4][5]=7;at[4][6]=2;at[4][7]=1;at[4][8]=4;
          at[5][0]=9;at[5][1]=7;at[5][2]=8;at[5][3]=2;at[5][4]=1;at[5][5]=4;at[5][6]=3;at[5][7]=6;at[5][8]=5;
          at[6][0]=5;at[6][1]=3;// at[6][2]=7;at[6][3]=6;at[6][4]=4;at[6][5]=2;at[6][6]=9;//at[6][7]=4;at[6][8]=1;
          */
            //extreme
            at[0][0]=8;
            at[1][2]=3;at[1][3]=6;
            at[2][1]=7;at[2][4]=9;at[2][6]=2;
            at[3][1]=5;at[3][5]=7;
            at[4][4]=4;at[4][5]=5;at[4][6]=7;
            at[5][3]=1;at[5][7]=3;
            at[6][2]=1;at[6][7]=6;at[6][8]=8;
            at[7][2]=8;at[7][3]=5;at[7][7]=1;
            at[8][1]=9;at[8][6]=4;  

          /*//double
          at[0][0]=9;at[0][1]=2;at[0][2]=6;at[0][3]=5;at[0][4]=7;at[0][5]=1;at[0][6]=4;at[0][7]=8;at[0][8]=3;
          at[1][0]=3;at[1][1]=5;at[1][2]=1;at[1][3]=4;at[1][4]=8;at[1][5]=6;at[1][6]=2;at[1][7]=7;at[1][8]=9;
          at[2][0]=8;at[2][1]=7;at[2][2]=4;at[2][3]=9;at[2][4]=2;at[2][5]=3;at[2][6]=5;at[2][7]=1;at[2][8]=6;
          at[3][0]=5;at[3][1]=8;at[3][2]=2;at[3][3]=3;at[3][4]=6;at[3][5]=7;at[3][6]=1;at[3][7]=9;at[3][8]=4;
          at[4][0]=1;at[4][1]=4;at[4][2]=9;at[4][3]=2;at[4][4]=5;at[4][5]=8;at[4][6]=3;at[4][7]=6;at[4][8]=7;
          at[5][0]=7;at[5][1]=6;at[5][2]=3;at[5][3]=1;at[5][4]=0;at[5][5]=0;at[5][6]=8;at[5][7]=2;at[5][8]=5;
          at[6][0]=2;at[6][1]=3;at[6][2]=8;at[6][3]=7;at[6][6]=6;at[6][7]=5;at[6][8]=1;
          at[7][0]=6;at[7][1]=1;at[7][2]=7;at[7][3]=8;at[7][4]=3;at[7][5]=5;at[7][6]=9;at[7][7]=4;at[7][8]=2;
          at[8][0]=4;at[8][1]=9;at[8][2]=5;at[8][3]=6;at[8][4]=1;at[8][5]=2;at[8][6]=7;at[8][7]=3;at[8][8]=8;
          */  
          /*  //easy
                             at[0][0]=4;at[0][2]=1;at[0][3]=2;at[0][4]=9;at[0][7]=7;at[0][8]=5;
                     at[1][0]=2;at[1][3]=3;at[1][6]=8;
                     at[2][1]=7;at[2][4]=8;at[2][8]=6;
                     at[3][3]=1;at[3][5]=3;at[3][7]=6;at[3][8]=2;
                     at[4][0]=1;at[4][2]=5;at[4][6]=4;at[4][8]=3;
                     at[5][0]=7;at[5][1]=3;at[5][3]=6;at[5][5]=8;
                     at[6][0]=6;at[6][4]=2;at[6][7]=3;
                     at[7][2]=7;at[7][5]=1;at[7][8]=4;
                     at[8][0]=8;at[8][1]=9;at[8][4]=6;at[8][5]=5;at[8][6]=1;at[8][8]=7;
          */       
          /*   //medium
          at[0][1]=8;at[0][6]=1;
          at[1][0]=3;at[1][3]=2;at[1][6]=5;
          at[2][4]=3;at[2][6]=4;at[2][8]=6;
          at[3][1]=6;at[3][3]=7;at[3][4]=4;at[3][8]=3;
          at[4][1]=7;at[4][3]=5;at[4][5]=3;at[4][7]=9;
          at[5][0]=9;at[5][4]=1;at[5][5]=2;at[5][7]=5;
          at[6][0]=5;at[6][2]=3;at[6][4]=6;
          at[7][2]=6;at[7][5]=1;at[7][8]=7;
          at[8][2]=1;at[8][7]=6;
           */
  }//end of create

 void display()
    {
     int i,j;
     for(i=0;i<9;++i)
     {
      for(j=0;j<9;++j)
       {
         System.out.print(at[i][j]+"  ");
         if(j==2||j==5)
          System.out.print("\t");
       }
      System.out.print("\n\n");
      if(i==2||i==5)
       System.out.print("\n\n\n");
     }
      System.out.print("\n\n\n");
  }
 void row()//finds the remaining no 
 {
    int P,i,j;
    boolean f;
    for(i=0;i<9;++i)
     {
      for(P=1,lr[i]=0;P<=9;++P)
       {
        for(j=0,f=true;j<9&&f;++j)
         if(P==at[i][j])
          f=false;
        if(f==true)
         {
           ar[i][lr[i]]=P;++lr[i];
         }//end of if
       }//end of P loop
      }//end of i loop
  }//end of row
 
void col()//find the remaining    
 {
    int P,i,j;
    boolean f;
    for(i=0;i<9;++i)
     {
      for(P=1,lc[i]=0;P<=9;++P)
       {
        for(j=0,f=true;j<9&&f;++j)
         if(P==at[j][i])
          f=false;
        if(f==true)
         {
           ac[i][lc[i]]=P;++lc[i];
         }//end of if
       }//end of P loop
      }//end of i loop
  }//end of col
 
 void box()//find the remaining
  {
   
        int S,P,m,n,i,j;
        boolean f;
         for(S=0;S<9;++S)
          {
            if(S==0)
             { i=0;j=0;}
            else if(S==1)
             { i=0;j=3;}
            else if(S==2)
             { i=0;j=6;}
            else if(S==3)
             { i=3;j=0;}
            else if(S==4)
             { i=3;j=3;}
            else if(S==5)
             { i=3;j=6;}
            else if(S==6)
             { i=6;j=0;}
            else if(S==7)   
             { i=6;j=3;}
            else
             { i=6;j=6;}
           for(P=1,lb[S]=0;P<=9;++P)
            {
             for(m=i,f=true;m<i+3&&f;++m)
             for(n=j;n<j+3&&f;++n)
              if(P==at[m][n])
               f=false;
             if(f==true)
              {ab[S][lb[S]]=P;++lb[S];}
            }//end of P loop
          }//end of  loop
   }//end of box

 void merge()
 {
  int S=0,p,q,r,i,j;
  for(i=0,mk=0;i<9;++i)
  for(j=0;j<9;++j)
   {
    if(at[i][j]==0)
     {
      if((i==0||i==1||i==2)&&(j==0||j==1||j==2))
       S=0;
      if((i==0||i==1||i==2)&&(j==3||j==4||j==5))
       S=1;
      if((i==0||i==1||i==2)&&(j==6||j==7||j==8))
       S=2;
      if((i==3||i==4||i==5)&&(j==0||j==1||j==2))
       S=3;
      if((i==3||i==4||i==5)&&(j==3||j==4||j==5))
       S=4;
      if((i==3||i==4||i==5)&&(j==6||j==7||j==8))
       S=5;
      if((i==6||i==7||i==8)&&(j==0||j==1||j==2))
       S=6;
      if((i==6||i==7||i==8)&&(j==3||j==4||j==5))
       S=7;
      if((i==6||i==7||i==8)&&(j==6||j==7||j==8))
       S=8;
     for(p=0,lm[mk]=0;p<lr[i];++p)
      {
       for(q=0;q<lc[j];++q)
        {
          if(ar[i][p]==ac[j][q])
           {
            for(r=0;r<lb[S];++r)
             {
              if(ar[i][p]==ab[S][r])
               {
                pos[mk][lm[mk]]=ar[i][p];
                mb[mk]=i*10+j;
                ++lm[mk];
               }
             }
           }
        }
     }
     ++mk;
    }
   }
  } 
 
 
 void nuroc()
  {
    int m=9,n=9,p,q,r,count,i,j;
   boolean f=false;
   for(i=0;f&&i<9;++i)
    {
     for(j=0;F&&j<lc[i];++j)
      {
       for(p=0,count=0;F&&p<mk;++p)
        {
         q=mb[i]%10;
         if(q==i)
          {
           for(r=0;F&&r<lm[i]&&F;++r)
            if(ac[i][j]==pos[p][r])
             {
              ++count;
              m=(mb[p]/10)%10;
              n=mb[p]%10;
             }
           }
          }
         if(count==1)
          {
           f=true;
           at[m][n]=ac[i][j];
           row();
     col();
     box();
     merge();
     flag();  
           }
         }
       }
     if(f==true)
     {
      
     nuro1();
    nuror();
    nuroc();
   
     }
     }
 
 void nurob()
  {
   int S,m=9,n=9,s=9,p,q,r,count,i,j;
   boolean f=false;
   for(S=0;F&&S<9;++S)
    {
     for(p=0;F&&p<lb[S];++p)
      {
       for(q=0,count=0;F&&q<mk;++q)
         {
          i=(mb[q]/10)%10;
          j=mb[q]%10;
          if((i==0||i==1||i==2)&&(j==0||j==1||j==2))
           s=0;
          if((i==0||i==1||i==2)&&(j==3||j==4||j==5))
           s=1;
          if((i==0||i==1||i==2)&&(j==6||j==7||j==8))
           s=2;
          if((i==3||i==4||i==5)&&(j==0||j==1||j==2))
           s=3;
          if((i==3||i==4||i==5)&&(j==3||j==4||j==5))
           s=4;
          if((i==3||i==4||i==5)&&(j==6||j==7||j==8))
           s=5;
          if((i==6||i==7||i==8)&&(j==0||j==1||j==2))
           s=6;
          if((i==6||i==7||i==8)&&(j==3||j==4||j==5))
           s=7;
          if((i==6||i==7||i==8)&&(j==6||j==7||j==8))
           s=8;
          if(S==s)
           {
            for(r=0;F&&r<lm[q];++r)
             if(ab[S][p]==pos[q][r])
              {
               ++count;
               m=(mb[q]/10)%10;
               n=mb[q]%10;
              }
           }
         }
        if(count==1)
         {
          f=true;
          at[m][n]=ab[S][p];
           row();
       col();
       box();
       merge();
       flag();
         }
       }
      }
     if(f==true)
      {
       nuro1();
       nuror();
       nuroc();
       nurob();
      }
     }

 
void nuro1()//add single pos
  {
   int m,n,i,j;
   boolean f=false;
  for(i=0;F&&i<mk;++i)
   {
    if(lm[i]==1)
     {
      f=true; 
      m=(mb[i]/10)%10;
      n=mb[i]%10;
      at[m][n]=pos[i][0];
       row();
     col();
     box();
     merge();
     flag();

     }
   }
   if(f==true&&F)
    {
    
     nuro1();
    }
  } 

 void nuror()//add the single pos in row
 {
   int m=9,n=9,p,q,r,count,i,j;
   boolean f=false;
  for(i=0;F&&i<9;++i)
   {
    for(p=0;F&&p<lr[i];++p)
     {
      for(j=0,count=0;F&&j<mk;++j)
       {
        r=(mb[j]/10)%10;
        if(r==i)
         {
          for(q=0;F&&q<lm[j];++q)
           if(ar[i][p]==pos[j][q])
            {
             ++count;
             m=(mb[j]/10)%10;
             n=mb[j]%10;
            }//end of if ar
         }//end of if m
        }//end of j
       if(count==1)
        {
          f=true;
          at[m][n]=ar[i][p];
          row();
          col();
          box();
          merge();
         flag(); 
        }//end of if count
     }//end of p
    }//end of i
   if(f==true&&F)
    {
     nuro1();  
     nuror();
    }
  }//end of nuror
 
void flag()
{
 


    boolean f1,f2,f3,f4,f5,f6,f7;
    int t,P,S,m,n,q,p,i,j,r;
    f1=f2=f3=f4=f5=f6=f7=true;
   //row
    for(i=0;i<9&&f1;++i)
     {
      for(P=1;P<=9&&f1;++P)
       {
        for(j=0,t=0;j<9;++j)
         if(at[i][j]==P)
          ++t;
        if(t>1)
         f1=false;
      }
     }
    //col
    for(i=0;i<9&&f2;++i)
     {
      for(P=1;P<=9&&f2;++P)
       {
        for(j=0,t=0;j<9;++j)
         if(at[j][i]==P)
          ++t;
        if(t>1)
         f2=false;
      }
     }
    // box
    for(S=0;S<9&&f3;++S)
     {
      if(S==0)
        { i=0;j=0;}
       else if(S==1)
        { i=0;j=3;}
       else if(S==2)
        { i=0;j=6;}
       else if(S==3)
        { i=3;j=0;}
       else if(S==4)
        { i=3;j=3;}
       else if(S==5)
        { i=3;j=6;}
       else if(S==6)
        { i=6;j=0;}
       else if(S==7)   
        { i=6;j=3;}
       else
        { i=6;j=6;}
       for(P=1;P<=9&&f3;++P)
        { 
         for(m=i,t=0;m<i+3;++m)
         for(n=j;n<j+3;++n)
          if(at[m][n]==P)
           ++t;
         if(t>1)
          {
           f3=false;
          }
        }
      }
   //missing in the row
   for(i=0;i<9&&f4;++i)
    {
     for(j=0;j<lr[i]&&f4;++j)
      {
       for(p=0,f4=false;p<mk;++p)
        {
         m=(mb[p]/10)%10;
         if(i==m)
          {
           for(q=0;q<lm[p];++q)
            if(ar[i][j]==pos[p][q])
             f4=true;
          }
        }
       }
     }                    
   //missing in the col
   for(i=0;i<9&&f5;++i)
    {
     for(j=0;j<lc[i]&&f5;++j)
      {
       for(p=0,f5=false;p<mk;++p)
        {
         m=mb[p]%10;
         if(i==m)
          {
           for(q=0;q<lm[p];++q)
            if(ac[i][j]==pos[p][q])
             f5=true;
          }
        }
       }
     }    
   //missing in the box        
    for(S=0;S<9&&f6;++S)
     {
       if(S==0)
        { i=0;j=0;}
       else if(S==1)
        { i=0;j=3;}
       else if(S==2)
        { i=0;j=6;}
       else if(S==3)
        { i=3;j=0;}
       else if(S==4)
        { i=3;j=3;}
       else if(S==5)
        { i=3;j=6;}
       else if(S==6)
        { i=6;j=0;}
       else if(S==7)   
        { i=6;j=3;}
       else
        { i=6;j=6;}
      for(t=0;t<lb[S]&&f6;++t)
       {
        for(p=0,f6=false;p<mk;++p)
         {
          q=(mb[p]/10)%10;
          r=mb[p]%10;
          if((q==i||q==(i+1)||q==(i+2))&&(r==j||r==(j+1)||r==(j+2)))
           {
            for(P=0;P<lm[p];++P)
             if(ab[S][t]==pos[p][P])
              f6=true;
           }
          }
        }
     }
     for(p=0;p<mk&&f7;++p)
      if(lm[p]==0)
       f7=false;
    F=true;
    if(f1==false||f2==false||f3==false||f4==false||f5==false||f6==false||f7==false)
     F=false;     
}

void add()
{
        int i,j;
        k=mb[0];
        kc=lm[0];int ht=0;
        for(sp=0,c[sp]=0,T=true;mk!=0&&T;)
        { 
            
         for(;mk!=0&&T;)
         {
          s[sp]=mb[0];
          for(i=0;i<9;++i)
          for(j=0;j<9;++j)
           atc[s[sp]][c[sp]][i][j]=at[i][j];
          at[(s[sp]/10)%10][s[sp]%10]=pos[0][c[sp]];
          row();
          col();
          box();
          merge();

            nuro1();
            nuror();
            nuroc();
            nurob();
            flag();

          if(F==false)
           {
            for(i=0;i<9;++i)
            for(j=0;j<9;++j)
             at[i][j]=atc[s[sp]][c[sp]][i][j];
            row();
            col();
            box();
            merge();
            nuro1();
            nuror();
            nuroc();
            nurob();
            if(s[sp]==k)
             if(c[sp]+1==kc)
               T=false;  
            if(T==true)
             {
              ++c[sp];
              checking();
             }
           }
          else
          { 
            if(mk!=0)
             {
              sp++;c[sp]=0;
             }
           }
          }
                                         /*if(mk==0)
                                          {
                                           ++count;
                                           System.out.println(count);
                                           if(count==100000000)
                                                {
                                                 count=0;
                                                 display();
                                                 String u;
                                                 u=br.readLine();
                                                }
                                          for(i=0;i<9;++i)
                                          for(j=0;j<9;++j)
                                           at[i][j]=atc[s[sp]][c[sp]][i][j];
                                           row();
                                                col();
                                                box();
                                                merge();
                                                nuro1();
                                                nuror();
                                                nuroc();
                                                nurob();

                                          if(s[sp]==k)
                                                 if(c[sp]+1==kc)
                                                   T=false; 
                                          if(T==true) 
                                           {
                                                ++c[sp];
                                                checking();
                                           }

                                          }*/
         } 
}
void checking()
{int i,j;
if(c[sp]>=lm[0])
   {
    sp--;
    for(i=0;i<9;++i)
    for(j=0;j<9;++j)
     at[i][j]=atc[s[sp]][c[sp]][i][j];
    row();
    col();
    box();
    merge();
    nuro1();
    nuror();
    nuroc();
    nurob();
    ++c[sp];
    if(s[sp]==k)
     if(c[sp]==kc)
       T=false; 
     if(T==true)
      checking();
   }
}
 int[][] solveSudoku(int[][] input)
 {
     at=input;
    
        row();
        col();
        box();
        merge();
        nuro1();
        nuror();
        nuroc();
        nurob();
        add();
     
    return at;
 }
}
 
/*class sudoku
{
 public static void main(String args[])
 {
  sud M=new sud();
   M.create();
   M.row();
    M.col();
    M.box();
    M.merge();
    M.nuro1();
    M.nuror();
    M.nuroc();
    M.nurob();
    M.add();
    M.display();
 }
}

*/
