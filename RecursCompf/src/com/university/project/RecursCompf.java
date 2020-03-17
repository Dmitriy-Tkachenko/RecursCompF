package com.university.project;

public class RecursCompf{
    private static final int DEFSIZE = 255;
    private char[] str;
    private int index;
    private boolean flag = false;

    public RecursCompf(){
        str = new char[DEFSIZE];
    }

    private void compileF(){
        compileT();

        if (index >= str.length)
            return;

        if (str[index] == '+'){
            index++;
            flag = true;
            compileF();
            System.out.print(" +");
            return;
        }


        if (str[index] == '-') {
            index++;
            flag = true;
            compileF();
            System.out.print(" -");
            return;
        }

        if (String.valueOf(str[index]).matches("[^\\-+*/]")) {
            flag = false;
            compileF();
        }
    }

    private void compileT(){
        compileM();

        if (index >= str.length)
            return;

        if (str[index] == '*'){
            index++;
            flag = true;
            compileT();
            System.out.print(" *");
            return;
        }

        if (str[index] == '/'){
            index++;
            flag = true;
            compileT();
            System.out.print(" /");
        }
    }

    private void compileM() {
        if (index >= str.length)
            return;

        if (str[index] == '('){
            index++;
            compileF();
            index++;
        }
        else
            compileV();
    }

    private void compileV(){
        if (flag) {
            System.out.print(" " + str[index++]);
            flag = false;
        } else System.out.print(str[index++]);
    }

    public void compile(char[] str){
        this.str = str;
        index = 0;
        compileF();
        System.out.print("\n");
    }
}
