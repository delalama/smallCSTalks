package com.example.workshits.controller;

import com.example.workshits.service.MyMercService.MyMercService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import static org.mockito.Mockito.when;

class MyMercControllerTest2 {
    String KAPOEN = "Kapoen";

    @Mock
    MyMercService myMockedService = Mockito.mock(MyMercService.class);

    @InjectMocks
    MyMercMeerjarenPlanController myMercMeerjarenPlanControllerWithAutoInjectedMockDependency;

    // this is needed
    @BeforeEach
    void init_mocks() {
        // I think that this method is the equivalent what you did on Merc
        MockitoAnnotations.initMocks(this);

        //  If you remember you can try to do it here and comment line 28
//        Mockito.supplyMocksOrSomethingLikeThat(MyMercService.class);
    }

    @Test
    public void testThatWorks(){
        when(myMockedService.getMeerjarenPlan()).thenReturn(KAPOEN);

        String meerjarenPlan = myMercMeerjarenPlanControllerWithAutoInjectedMockDependency.getMeerjarenPlan();
        Assertions.assertNotNull(meerjarenPlan);
    }


    @Mock
    MyMercService myMercService2 = Mockito.mock(MyMercService.class);

    // I suppose that the pending @InjectMocks is what is needed to make the second test run........ no ?
    MyMercMeerjarenPlanController myMercMeerjarenPlanController = new MyMercMeerjarenPlanController(myMercService2);

    @Test
    public void testThatDoesNotWorkBecauseSpringDoesNotKnowToInjectAMock(){
        when(myMercService2.getMeerjarenPlan()).thenReturn(KAPOEN);

        String receivedMeerjarenPlan = myMercMeerjarenPlanController.getMeerjarenPlan();
        Assertions.assertNotNull(receivedMeerjarenPlan);
    }
}
