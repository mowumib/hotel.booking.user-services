package com.hotel.booking.hotel_services.service;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.hotel.booking.hotel_services.dto.BaseResponseDto;
import com.hotel.booking.hotel_services.dto.CreateUserDto;
import com.hotel.booking.hotel_services.dto.ResponseModel;
import com.hotel.booking.hotel_services.dto.SignInDto;
import com.hotel.booking.hotel_services.dto.otp.OtpTokenValidatorDto;
import com.hotel.booking.hotel_services.dto.password.UpdatePasswordDto;


public interface UserService {
    public ResponseModel createClientUser(@RequestBody CreateUserDto dto);

    public ResponseModel createAdminUser(@RequestBody CreateUserDto dto);

    public BaseResponseDto signIn(@RequestBody SignInDto dto);

    public BaseResponseDto verifyOtpCode(@RequestBody OtpTokenValidatorDto dto);

    public BaseResponseDto resendOtpCode(@RequestParam String email);

    public BaseResponseDto updatePassword(@RequestBody UpdatePasswordDto dto);
}
