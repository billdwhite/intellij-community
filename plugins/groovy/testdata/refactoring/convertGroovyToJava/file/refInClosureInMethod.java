public class X {
public void foo() {
final groovy.lang.Reference<java.lang.Integer> ab = new groovy.lang.Reference<java.lang.Integer>(4);
org.codehaus.groovy.runtime.DefaultGroovyMethods.each(this, new groovy.lang.Closure<java.lang.Object>(this, this) {
public java.lang.Object doCall(java.lang.Object it) {
return org.codehaus.groovy.runtime.DefaultGroovyMethods.each(this, new groovy.lang.Closure<java.lang.Integer>(this, this) {
public java.lang.Integer doCall(java.lang.Object it) {
return setGroovyRef(ab, 2);
}

public java.lang.Integer doCall() {
return doCall(null);
}

});
}

public java.lang.Object doCall() {
return doCall(null);
}

});
org.codehaus.groovy.runtime.DefaultGroovyMethods.print(this, ab.get());
}

private static <T> T setGroovyRef(groovy.lang.Reference<T> ref, T newValue) {
ref.set(newValue);
return newValue;
}}
