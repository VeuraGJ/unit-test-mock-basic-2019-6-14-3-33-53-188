package cashregister;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class CashRegisterTest {


    @Test
    public void should_print_the_real_purchase_when_call_process() {
        //given
        FakePrinter fakeprinter = new FakePrinter();
        CashRegister cashRegister = new CashRegister(fakeprinter);
        Item[] items={new Item("Q",4.5),new Item("A",2.5)};
        Purchase purchase = new Purchase(items);
        //when
        cashRegister.process(purchase);
        //then
        assertTrue(fakeprinter.isMethodCalled());
    }

    @Test
    public void should_print_the_stub_purchase_when_call_process() {
        //given
        FakePrinter fakePrinter = new FakePrinter();
        CashRegister cashRegister = new CashRegister(fakePrinter);
        Item[] items={new Item("Q",4.5),new Item("A",2.5)};
        FakePurchase fakePurchase = new FakePurchase(items);
        fakePurchase.setPurchaseMessage("TEST");
        //when
        cashRegister.process(fakePurchase);
        //then
        assertSame(fakePurchase.asString(),fakePrinter.getPrintMesage());
    }

    @Test
    public void should_verify_with_process_call_with_mockito() {
        //given
        Printer printer = mock(Printer.class);
        Purchase purchase = mock(Purchase.class);
        when(purchase.asString()).thenReturn("TEST");
        CashRegister cashRegister = new CashRegister(printer);
        //when
        cashRegister.process(purchase);
        //then
        verify(printer).print("TEST");
    }

}
