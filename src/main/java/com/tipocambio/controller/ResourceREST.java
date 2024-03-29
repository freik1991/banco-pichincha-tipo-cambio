package com.tipocambio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tipocambio.dto.Message;
import com.tipocambio.security.jwt.JWTUtil;
import com.tipocambio.security.jwt.PBKDF2Encoder;

/**
 *
 * @author ard333
 */
@RestController
public class ResourceREST {
	
	@GetMapping("/resource/user")
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<?> user() {
		return ResponseEntity.ok(new Message("Content for user"));
	}
	
	@GetMapping("/resource/admin")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> admin() {
		return ResponseEntity.ok(new Message("Content for admin"));
	}
	
	@GetMapping("/resource/user-or-admin")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public ResponseEntity<?> userOrAdmin() {
		return ResponseEntity.ok(new Message("Content for user or admin"));
	}
}
