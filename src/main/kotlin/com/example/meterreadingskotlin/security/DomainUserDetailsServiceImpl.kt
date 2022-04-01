package com.example.meterreadingskotlin.security

import com.example.meterreadingskotlin.domain.User
import com.example.meterreadingskotlin.repository.UserRepository
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service
import java.util.stream.Collectors
import javax.transaction.Transactional


@Service
@Transactional
class DomainUserDetailsServiceImpl(private val userRepository: UserRepository) : UserDetailsService {

    override fun loadUserByUsername(username: String?): UserDetails {
        val user: User = userRepository.findByUsername(username)
            .orElseThrow { UsernameNotFoundException("User NOT Found") }
        return createSpringSecurityUser(user)
    }

    private fun createSpringSecurityUser(user: User): org.springframework.security.core.userdetails.User {
        val authorities: List<SimpleGrantedAuthority> = user.roles!!.stream()
            .map { role -> SimpleGrantedAuthority("ROLE_" + role.name) }.collect(Collectors.toList())

        return User(
            user.username,
            user.password,
            authorities
        )
    }
}
