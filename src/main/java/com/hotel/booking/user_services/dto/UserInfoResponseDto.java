package com.hotel.booking.user_services.dto;

import java.util.List;

import com.hotel.booking.user_services.entity.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoResponseDto {
  private String jwt;
  private User user;
}
