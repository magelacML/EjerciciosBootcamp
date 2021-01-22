package Controller;

public class CuentaCorriente {

        private double saldo;
        private int numCuenta;

        public double getSaldo(){
            return saldo;
        }
        public void setSaldo(double saldo){
            this.saldo = saldo;
        }

        public int getCuenta(){
            return this.numCuenta;
        }
        public void setCuenta(int numCuenta){
            this.numCuenta = numCuenta;
        }


        public CuentaCorriente(int numCuenta, double saldo){
            this.saldo = saldo;
            this.numCuenta = numCuenta;
        }




        public CuentaCorriente(int a){

        }

        public static void ingreso (int a){}
        public static void egreso (int a){}
        public static void reintegro (int a){}
        public static void transferencia (int a){}

        public static void main(String[] args) {
        }
    }

