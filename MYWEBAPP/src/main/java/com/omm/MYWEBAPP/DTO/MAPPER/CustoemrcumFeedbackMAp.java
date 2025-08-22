package com.omm.MYWEBAPP.DTO.MAPPER;

import com.omm.MYWEBAPP.DTO.InputDTO.Feedbackinput;
import com.omm.MYWEBAPP.DTO.InputDTO.customerinputdto;
import com.omm.MYWEBAPP.DTO.OUTPUTDTO.Feedbackoutputdto;
import com.omm.MYWEBAPP.DTO.OUTPUTDTO.CustomerDto;
import com.omm.MYWEBAPP.DTO.OUTPUTDTO.customeroutputdto;
import com.omm.MYWEBAPP.Entity.Customer_entity;
import com.omm.MYWEBAPP.Entity.FeedbackEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.time.LocalDate;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CustoemrcumFeedbackMAp {
    Customer_entity toCustomerEntity(customerinputdto customerinputdto);
    CustomerDto toCustomerOutputDto(Customer_entity entity);






    @Mapping(source = "customer", target = "customer")
    FeedbackEntity toFeedbackEntity(Feedbackinput feedbackinput);


    @Mapping(source = "customer", target =    "customer")
    Feedbackoutputdto toFeedbackOutputDto(FeedbackEntity entity);


}
