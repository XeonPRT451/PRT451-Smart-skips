package cdu.xeon.basic_common.esapi;

/**
 * Created by Administrator on 1/04/2018.
 */

import org.owasp.esapi.ESAPI;

public class EsapiTest {
    public static void main(String[] args) {

        String safe = ESAPI.encoder().encodeForHTML("<script>alert('xss')</script>");

        System.out.println(safe);
    }

}