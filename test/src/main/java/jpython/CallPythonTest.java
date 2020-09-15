package jpython;

import org.junit.Test;
import org.python.core.*;
import org.python.util.PythonInterpreter;


public class CallPythonTest {
    private PythonInterpreter interpreter = new PythonInterpreter();

    @Test
    public void get() {

        interpreter.execfile("F:\\webmagic_temp\\python\\hellow.py");
        PyFunction func = (PyFunction) interpreter.get("adder", PyFunction.class);

        int a = 2010, b = 2;
        PyObject pyobj = func.__call__(new PyInteger(a), new PyInteger(b));
        System.out.println("anwser = " + pyobj.toString());
    }


    @Test
    public void getDoamin(){

        PySystemState system = Py.getSystemState();
        system.path.add("F:\\envWorkspace\\common\\lib\\site-packages");
//        interpreter.exec("import tldextract as tld");
//        interpreter.exec("print(tld.tldextract.extract(\"http://www.baidu.com.cn\"))");
        interpreter.execfile("F:\\webmagic_temp\\python\\hellow.py");
        PyFunction getDomain = interpreter.get("get_domain", PyFunction.class);
        String url = "http://www.baidu.com.cn";
        PyObject pyres = getDomain.__call__(new PyString(url));
        System.out.println("res = > " + pyres.toString());
        interpreter.close();
    }


    @Test
    public void getDoamin4j(){

        PySystemState system = Py.getSystemState();
        system.path.add("F:\\envWorkspace\\common\\lib\\site-packages");
        interpreter.exec("import tldextract as tld");
        interpreter.compile("def get_domain(url):\n\treturn tld.tldextract.extract(\"http://www.baidu.com.cn\").domain");
        PyFunction getDomain = interpreter.get("get_domain", PyFunction.class);
        String url = "http://www.baidu.com.cn";
        PyObject pyres = getDomain.__call__(new PyString(url));
        System.out.println("res = > " + pyres.toString());


        interpreter.close();
    }

}