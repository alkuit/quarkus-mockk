package org.acme

import io.mockk.every
import io.mockk.mockk
import io.quarkus.test.junit.QuarkusMock
import io.quarkus.test.junit.QuarkusTest
import org.eclipse.microprofile.rest.client.inject.RestClient
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import javax.enterprise.inject.Default
import javax.inject.Inject

@QuarkusTest
class CountryServiceIntTest {

    companion object {
        @RestClient
        val countryAccessor: CountryAccessor = mockk()
        @BeforeAll
        @JvmStatic
        fun setupMocks() {
            QuarkusMock.installMockForType(countryAccessor, CountryAccessor::class.java)
        }
    }

    @Inject
    @field: Default
    lateinit var countryService: CountryService

    @Test
    fun `should mock the accessor`() {
        every { countryAccessor.getByName("greece") } returns setOf(Country())
        countryService.getCountryByName("greece")
    }
}
