/**
 * **********************************************************************
 * Freeware License Agreement
 * <p>
 * This license agreement only applies to the free version of this software.
 * <p>
 * Terms and Conditions
 * <p>
 * BY DOWNLOADING, INSTALLING, USING, TRANSMITTING, DISTRIBUTING OR COPYING THIS SOFTWARE ("THE SOFTWARE"), YOU AGREE TO THE TERMS OF THIS AGREEMENT (INCLUDING THE SOFTWARE LICENSE AND DISCLAIMER OF WARRANTY) WITH METAMUG THE OWNER OF ALL RIGHTS IN RESPECT OF THE SOFTWARE.
 * <p>
 * PLEASE READ THIS DOCUMENT CAREFULLY BEFORE USING THE SOFTWARE.
 * <p>
 * IF YOU DO NOT AGREE TO ANY OF THE TERMS OF THIS LICENSE THEN DO NOT DOWNLOAD, INSTALL, USE, TRANSMIT, DISTRIBUTE OR COPY THE SOFTWARE.
 * <p>
 * THIS DOCUMENT CONSTITUTES A LICENSE TO USE THE SOFTWARE ON THE TERMS AND CONDITIONS APPEARING BELOW.
 * <p>
 * The Software is licensed to you without charge for use only upon the terms of this license, and METAMUG TECHNOLOGIES LLP (hereafter METAMUG) reserves all rights not expressly granted to you. METAMUG retains ownership of all copies of the Software.
 * <p>
 * 1. License
 * <p>
 * You may use the Software without charge.
 * <p>
 * You may freely distribute exact copies of the Software to anyone.
 * <p>
 * The inclusion of the Software in any Shareware, Freeware or similar media compilation or distribution method whereby it is made available at cost (ie. sold) is strictly prohibited.
 * <p>
 * The selling of the Software is strictly prohibited.
 * 2. Restrictions
 * <p>
 * METAMUG reserves the right to revoke the above distribution right at any time, for any or no reason.
 * <p>
 * YOU MAY NOT MODIFY, ADAPT, TRANSLATE, RENT, LEASE, LOAN, SELL, ONSELL, REQUEST DONATIONS OR CREATE DERIVATIVE WORKS BASED UPON THE SOFTWARE OR ANY PART THEREOF.
 * <p>
 * The Software contains intellectual property and to protect them you may not decompile, reverse engineer, disassemble or otherwise reduce the Software to a humanly perceivable form. You agree not to divulge, directly or indirectly, until such intellectual property cease to be confidential, for any reason not your own fault.
 * <p>
 * 3. Termination
 * <p>
 * This license is effective until terminated. The License will terminate automatically without notice from METAMUG if you fail to comply with any provision of this License. Upon termination you must destroy the Software and all copies thereof. You may terminate this License at any time by destroying the Software and all copies thereof. Upon termination of this license for any reason you shall continue to be bound by the provisions of Section 2 above. Termination will be without prejudice to any rights METAMUG may have as a result of this agreement.
 * <p>
 * 4. Disclaimer of Warranty, Limitation of Remedies
 * <p>
 * TO THE FULL EXTENT PERMITTED BY LAW, METAMUG HEREBY EXCLUDES ALL CONDITIONS AND WARRANTIES, WHETHER IMPOSED BY STATUTE OR BY OPERATION OF LAW OR OTHERWISE, NOT EXPRESSLY SET OUT HEREIN. THE SOFTWARE, AND ALL ACCOMPANYING FILES, DATA AND MATERIALS ARE DISTRIBUTED "AS IS" AND WITH NO WARRANTIES OF ANY KIND, WHETHER EXPRESS OR IMPLIED. METAMUG DOES NOT WARRANT, GUARANTEE OR MAKE ANY REPRESENTATIONS REGARDING THE USE, OR THE RESULTS OF THE USE, OF THE SOFTWARE WITH RESPECT TO ITS CORRECTNESS, ACCURACY, RELIABILITY, CURRENTNESS OR OTHERWISE. THE ENTIRE RISK OF USING THE SOFTWARE IS ASSUMED BY YOU. METAMUG MAKES NO EXPRESS OR IMPLIED WARRANTIES OR CONDITIONS INCLUDING, WITHOUT LIMITATION, THE WARRANTIES OF MERCHANTABILITY OR FITNESS FOR A PARTICULAR PURPOSE WITH RESPECT TO THE SOFTWARE. NO ORAL OR WRITTEN INFORMATION OR ADVICE GIVEN BY METAMUG, IT'S DISTRIBUTORS, AGENTS OR EMPLOYEES SHALL CREATE A WARRANTY, AND YOU MAY NOT RELY ON ANY SUCH INFORMATION OR ADVICE.
 * <p>
 * IMPORTANT NOTE: Nothing in this Agreement is intended or shall be construed as excluding or modifying any statutory rights, warranties or conditions which by virtue of any national or state Fair Trading, Trade Practices or other such consumer legislation may not be modified or excluded. If permitted by such legislation, however, METAMUG's liability for any breach of any such warranty or condition shall be and is hereby limited to the supply of the Software licensed hereunder again as METAMUG at its sole discretion may determine to be necessary to correct the said breach.
 * <p>
 * IN NO EVENT SHALL METAMUG BE LIABLE FOR ANY SPECIAL, INCIDENTAL, INDIRECT OR CONSEQUENTIAL DAMAGES (INCLUDING, WITHOUT LIMITATION, DAMAGES FOR LOSS OF BUSINESS PROFITS, BUSINESS INTERRUPTION, AND THE LOSS OF BUSINESS INFORMATION OR COMPUTER PROGRAMS), EVEN IF METAMUG OR ANY METAMUG REPRESENTATIVE HAS BEEN ADVISED OF THE POSSIBILITY OF SUCH DAMAGES. IN ADDITION, IN NO EVENT DOES METAMUG AUTHORIZE YOU TO USE THE SOFTWARE IN SITUATIONS WHERE FAILURE OF THE SOFTWARE TO PERFORM CAN REASONABLY BE EXPECTED TO RESULT IN A PHYSICAL INJURY, OR IN LOSS OF LIFE. ANY SUCH USE BY YOU IS ENTIRELY AT YOUR OWN RISK, AND YOU AGREE TO HOLD METAMUG HARMLESS FROM ANY CLAIMS OR LOSSES RELATING TO SUCH UNAUTHORIZED USE.
 * <p>
 * 5. General
 * <p>
 * All rights of any kind in the Software which are not expressly granted in this Agreement are entirely and exclusively reserved to and by METAMUG.
 * <p>
 * This Agreement shall be governed by the laws of the State of Maharashtra, India. Exclusive jurisdiction and venue for all matters relating to this Agreement shall be in courts and fora located in the State of Maharashtra, India, and you consent to such jurisdiction and venue. This agreement contains the entire Agreement between the parties hereto with respect to the subject matter hereof, and supersedes all prior agreements and/or understandings (oral or written). Failure or delay by METAMUG in enforcing any right or provision hereof shall not be deemed a waiver of such provision or right with respect to the instant or any subsequent breach. If any provision of this Agreement shall be held by a court of competent jurisdiction to be contrary to law, that provision will be enforced to the maximum extent permissible, and the remaining provisions of this Agreement will remain in force and effect.
 */
package com.metamug.mason.io.objectreturn;

import com.metamug.mason.io.objectreturn.testclasses.Customer;
import com.metamug.mason.io.objectreturn.testclasses.PhoneNumber;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import javax.xml.bind.JAXBException;
import java.util.ArrayList;
import java.util.List;

public class ObjectReturnTest {

    private Customer customer1, customer2, customer3;
    private final List<Customer> list = new ArrayList<>();

    @Before
    public void init() {
        customer1 = new Customer(1, "John", "Doe");
        PhoneNumber pn = new PhoneNumber();
        pn.setNum("9128992849");
        pn.setType("mobile");
        customer1.addPhoneNumber(pn);
        list.add(customer1);

        customer2 = new Customer(2, "Al", "Fred");
        pn = new PhoneNumber();
        pn.setNum("1204597612");
        pn.setType("work");
        customer2.addPhoneNumber(pn);
        list.add(customer2);

        customer3 = new Customer(3, "Mason", "Rich");
        pn = new PhoneNumber();
        pn.setNum("1642953181");
        pn.setType("work");
        customer3.addPhoneNumber(pn);
        list.add(customer3);
    }

    @Test
    public void ObjectToJsonTest() {
        try {
            String resultJson = ObjectReturn.convert(customer1, ObjectReturn.TYPE_JSON);
            //System.out.println(resultJson);
            JSONObject jsonObject = new JSONObject(resultJson);
            Assert.assertNotNull(jsonObject);
        } catch (JSONException | JAXBException e) {
            Assert.fail(e.toString());
        }
    }

    @Test
    public void ObjectToXmlTest() {
        try {
            String resultXml = ObjectReturn.convert(customer1, ObjectReturn.TYPE_XML);
            //    System.out.println(resultXml);
            Assert.assertNotNull(resultXml);
        } catch (JAXBException ex) {
            Assert.fail(ex.toString());
        }
    }

    @Test
    public void StringTest() {
        try {
            String result = ObjectReturn.convert("Response String", "Ignored header");
            //  System.out.println(result);
            Assert.assertNotNull(result);
        } catch (JAXBException ex) {
            Assert.fail(ex.toString());
        }
    }

    //object lists conversion not yet supported
    @Ignore
    @Test
    public void ObjectListToJsonTest() {
        try {
            String result = ObjectReturn.convert(list, ObjectReturn.TYPE_JSON);
            //System.out.println(result);
            JSONArray jsonArray = new JSONArray(result);
            Assert.assertNotNull(jsonArray);
        } catch (JSONException | JAXBException e) {
            Assert.fail(e.toString());
        }
    }

    @Ignore
    @Test
    public void ObjectListToXml() {
        try {
            String result = ObjectReturn.convert(list, ObjectReturn.TYPE_XML);
            //System.out.println(result);
            Assert.assertNotNull(result);
        } catch (JAXBException ex) {
            Assert.fail(ex.toString());
        }
    }

}
