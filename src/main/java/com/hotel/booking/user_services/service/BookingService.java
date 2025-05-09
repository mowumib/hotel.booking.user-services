package com.hotel.booking.user_services.service;

import com.hotel.booking.user_services.dto.BookingDto;
import com.hotel.booking.user_services.dto.ResponseModel;

public interface BookingService {
    // public ResponseModel bookRoom(String userCode, String hotelCode);

    public ResponseModel bookRoom(String hotelCode, String userCode, BookingDto dto);

    public ResponseModel cancelBooking(String bookingCode);

    public ResponseModel getAllBookingsByUserCode(String userCode);

    public ResponseModel getBookingByCode(String bookingCode);

    public ResponseModel getAllBookingsByHotelCode(String hotelCode);

    public ResponseModel completeBooking(String bookingCode);

    public ResponseModel getAllBooking();

    // public Booking completeBooking(String bookingCode);

}
