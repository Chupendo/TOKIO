module B {
	//requires C;
	//
	requires transitive C;
	exports com.tokio.b;
}