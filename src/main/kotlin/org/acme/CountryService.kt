package org.acme

import org.eclipse.microprofile.rest.client.inject.RestClient
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class CountryService(
    @RestClient private val countryAccessor: CountryAccessor
) {

    fun getCountryByName(name: String): Set<Country> {
        return countryAccessor.getByName(name)
    }
}
