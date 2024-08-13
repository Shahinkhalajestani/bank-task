package com.shahinkhalajestani.banktask.customer.service;

import java.util.Optional;

import com.shahinkhalajestani.banktask.base.exception.DuplicateRecordException;
import com.shahinkhalajestani.banktask.customer.dao.CustomerDao;
import com.shahinkhalajestani.banktask.customer.model.Customer;
import com.shahinkhalajestani.banktask.customer.model.CustomerType;
import com.shahinkhalajestani.banktask.customer.service.Impl.AdminCustomerServiceImpl;
import com.shahinkhalajestani.banktask.customer.service.dto.CustomerSaveDto;
import com.shahinkhalajestani.banktask.customer.service.mapper.AdminCustomerServiceMapperImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@Import({ AdminCustomerServiceMapperImpl.class, AdminCustomerServiceImpl.class })
@TestPropertySource("classpath:application-test.properties")
public class CustomerServiceTest {

	@Autowired
	private AdminCustomerService adminCustomerService;

	@MockBean
	private CustomerDao customerDao;


	@Test
	@DisplayName("testing storing real customer success")
	void saveCustomer_1() {
		var name = "shahin";
		var lastName = "khalajestani";
		var phoneNumber = "09333333333";
		var type = CustomerType.REAL;
		var customerSaveDto = new CustomerSaveDto();
		customerSaveDto.setCustomerType(type);
		customerSaveDto.setName(name);
		customerSaveDto.setLastName(lastName);
		customerSaveDto.setPhoneNumber(phoneNumber);
		when(customerDao.findByPhoneNumber(eq(phoneNumber))).thenReturn(Optional.empty());
		when(customerDao.save(any())).thenReturn(new Customer());
		adminCustomerService.saveCustomer(customerSaveDto);
		verify(customerDao, times(1)).save(any());
	}


	@Test
	@DisplayName("testing storing real customer failure")
	void saveCustomer_2() {
		var name = "shahin";
		var lastName = "khalajestani";
		var phoneNumber = "09333333333";
		var type = CustomerType.REAL;
		var customerSaveDto = new CustomerSaveDto();
		customerSaveDto.setCustomerType(type);
		customerSaveDto.setName(name);
		customerSaveDto.setLastName(lastName);
		customerSaveDto.setPhoneNumber(phoneNumber);
		var customer = new Customer();
		when(customerDao.findByPhoneNumber(eq(phoneNumber))).thenReturn(Optional.of(customer));
		when(customerDao.save(any())).thenReturn(new Customer());
		assertThrows(DuplicateRecordException.class, () -> adminCustomerService.saveCustomer(customerSaveDto));
		verify(customerDao, times(0)).save(any());
	}

}
