package com.example.powermockitojunit;

import com.example.powermockitojunit.Util.NotificationUtil;
import com.example.powermockitojunit.dto.OrderRequest;
import com.example.powermockitojunit.dto.OrderResponse;
import com.example.powermockitojunit.servive.ProductService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.doReturn;

@RunWith(PowerMockRunner.class)
@PrepareForTest(fullyQualifiedNames ="com.example.powermockitojunit.*")
public class PowerMockitoJunitApplicationTests {

    @InjectMocks
    private ProductService service;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(NotificationUtil.class);
    }

    OrderRequest request = new OrderRequest(111,"Mobile",1,10000,"test@gmail.com",true);

    //Static method

    @Test
    public void testStaticMethod(){
        //Given
        String emailId="test@gmail.com";
        PowerMockito.mockStatic(NotificationUtil.class);
        //When
        when(NotificationUtil.sendEmail(emailId)).thenReturn("success");
        //Then
       OrderResponse response = service.checkOutOrder(request);
       assertEquals("success",response.getMessage());
    }


    //Private Methods
   @Test
    public void testForPrivateMethod() throws Exception{
        //Given
    ProductService spy = PowerMockito.spy(service);
    doReturn(1000).when(spy,"addDiscount", ArgumentMatchers.any());

    //Then
    OrderResponse response = spy.checkOutOrder(request);
    int price = response.getResponse().getPrice();//9000
       System.out.println("*----price----*"+price);
    assertEquals(9000,price);




}

}
