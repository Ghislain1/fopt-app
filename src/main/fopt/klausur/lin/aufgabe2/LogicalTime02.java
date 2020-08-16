package fopt.klausur.lin.aufgabe2;

public class LogicalTime02 {
        public static int MAX_NUMBER_OF_TICKS_LONG = 10;

        public static int MAX_NUMBER_OF_TICKS_SMALL = 5;

        private int nextWaitingNumber;

        private int nextPassingNumber;

        private int ticks;

        public LogicalTime02()
        {
            this.nextWaitingNumber = 0;
            this.nextPassingNumber = 0;
            this.ticks = 1; // NOT Zero , because the first enter thread should wait
        }

        public synchronized void tick()
        {

            if (this.ticks == 0)
            {

                this.notifyAll();

            }
            else
            {
                this.ticks--;
            }

            System.out.println(Thread.currentThread().getName() + "---- tick() " + this.ticks);

        }

        public synchronized void waitTicks(int waitingTicks)
        {
            // Nummber ziehen
            int myNumber = this.nextWaitingNumber;

            // Wartenummer bereitstellen
            this.nextWaitingNumber++;

            while (this.ticks > 0 || myNumber != this.nextPassingNumber)
            {
                try
                {

                    this.wait();

                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
            this.ticks = waitingTicks;
            this.nextPassingNumber++;
            System.out.println(Thread.currentThread().getName() + "---- ticks " + ticks  );
            System.out.println(Thread.currentThread().getName() + "---- nextPassingNumber " + nextPassingNumber );
            this.notifyAll();

        }

}
