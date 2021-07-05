class FooBar {
    private int n;
    Object obj = new Object();

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException, IllegalMonitorStateException {
        
        for (int i = 0; i < n; i++) {
            
        	// printFoo.run() outputs "foo". Do not change or remove this line.
        	printFoo.run();
            printBar.join();
        }
        
    }


    public void bar(Runnable printBar) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            
            // printBar.run() outputs "bar". Do not change or remove this line.
        	printBar.run();
            printFoo.join();
        }
    }
}


class FooBar {
  private int n;
  private final Semaphore fooSync;
  private final Semaphore barSync;
  
  public FooBar(int n) {
    this.n = n;
    this.fooSync = new Semaphore(1);
    this.barSync = new Semaphore(0);
  }

  public void foo(Runnable printFoo) throws InterruptedException {

    for (int i = 0; i < n; i++) {
      this.fooSync.acquireUninterruptibly();
      // printFoo.run() outputs "foo". Do not change or remove this line.
      printFoo.run();
      this.barSync.release();
    }
  }

  public void bar(Runnable printBar) throws InterruptedException {
    for (int i = 0; i < n; i++) {
      this.barSync.acquireUninterruptibly();
        // printBar.run() outputs "bar". Do not change or remove this line.
      printBar.run();
      this.fooSync.release();
    }
  }
}
