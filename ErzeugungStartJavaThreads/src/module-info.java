module asd {
	 // this module only needs types from the base module 'java.base';
    // because every Java module needs 'java.base', it is not necessary
    // to explicitly require it - I do it nonetheless for demo purposes
    requires java.base;
    exports fopt.buch;
}