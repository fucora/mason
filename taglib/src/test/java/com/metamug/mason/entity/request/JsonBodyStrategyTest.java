package com.metamug.mason.entity.request;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.nio.charset.StandardCharsets;
import javax.xml.bind.JAXBException;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class JsonBodyStrategyTest {

    @Mock
    private HttpServletRequest request;

    @Before
    public void setUp() throws IOException {

        request = mock(HttpServletRequest.class);
        when(request.getPathInfo()).thenReturn("/v1.0/info/crm/people/customer/12");
        when(request.getServletPath()).thenReturn("/v1.0/info/crm/people/customer/12");
        when(request.getMethod()).thenReturn("GET");

        System.setProperty("javax.xml.bind.context.factory", "org.eclipse.persistence.jaxb.JAXBContextFactory");

        String json = "{\n"
                + "\t\"customer\": {\n"
                + "      \"name\": \"John Doeyy.\",\n"
                + "      \"roll\": 555,\n"
                + "      \"id\": 8\n"
                + "    }\n"
                + "}";

        Reader inputString = new StringReader(json);
        BufferedReader reader = new BufferedReader(inputString);
        when(request.getReader()).thenReturn(reader);

        ByteArrayInputStream bytestream = new ByteArrayInputStream(json.getBytes(StandardCharsets.UTF_8));
        ServletInputStream stream = getServletInputStream(bytestream);
        when(request.getInputStream()).thenReturn(stream);

    }

    @Test
    public void jsonBodyUnmarshal() throws IOException, JAXBException {

        RequestBodyStrategy masonRequest = new JsonBodyStrategy(Customer.class);
        //System.out.println(request.getInputStream());

        Object object = masonRequest.getBodyObject(request.getInputStream());

        Customer customer = (Customer) object;

        String name = customer.getName();
        System.out.println(customer);
        System.out.println(name);
        Assert.assertEquals("John Doeyy.", name);
    }

    private ServletInputStream getServletInputStream(ByteArrayInputStream bytestream) {
        return new ServletInputStream() {
            @Override
            public boolean isFinished() {
                return false;
            }

            @Override
            public boolean isReady() {
                return false;
            }

            @Override
            public void setReadListener(ReadListener readListener) {

            }

            public int read() throws IOException {
                return bytestream.read();
            }
        };
    }

}
