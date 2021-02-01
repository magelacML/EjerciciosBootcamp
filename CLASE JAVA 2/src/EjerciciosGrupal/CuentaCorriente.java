package EjerciciosGrupal;

public class CuentaCorriente {

        private double saldo;
        private int numCuenta;

        public CuentaCorriente(int numCuenta, double saldo){
            this.saldo = saldo;
            this.numCuenta = numCuenta;
        }

        public CuentaCorriente(){
            this.saldo = 0;
            this.numCuenta = (int) Math.random();
        }

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

        public void ingreso (int a){
            this.saldo = this.saldo + a;
        }
        public void egreso (int a){
            this.saldo = this.saldo - a;
        }
        public void reintegro (int a){
            ingreso(a);
        }
        public void transferencia (int a){
            egreso(a);
        }
    }

