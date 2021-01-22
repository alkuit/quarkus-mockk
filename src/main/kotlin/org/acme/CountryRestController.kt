package org.acme

import org.jboss.resteasy.annotations.jaxrs.PathParam
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

@Path("/countries")
class CountryRestController(
    val countryService: CountryService
) {

    @GET
    @Path("/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    fun getCountryByName(@PathParam name: String): Response = Response.ok(countryService.getCountryByName(name)).build()
}
