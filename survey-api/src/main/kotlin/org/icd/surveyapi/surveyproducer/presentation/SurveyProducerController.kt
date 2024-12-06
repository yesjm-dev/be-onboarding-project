package org.icd.surveyapi.surveyproducer.presentation

import org.icd.surveyapi.surveyproducer.application.SurveyProducerService
import org.icd.surveyapi.surveyproducer.application.dto.request.GetSurveyRequest
import org.icd.surveyapi.surveyproducer.application.dto.request.PatchSurveyRequest
import org.icd.surveyapi.surveyproducer.application.dto.request.PostSurveyRequest
import org.icd.surveyapi.surveyproducer.application.dto.response.GetSurveyResponse
import org.icd.surveyapi.surveyproducer.application.dto.response.GetSurveyResponseResponse
import org.icd.surveyapi.surveyproducer.application.dto.response.PostSurveyResponse
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/v1/survey")
class SurveyProducerController(
    private val surveyProducerService: SurveyProducerService
) {
    @PostMapping
    fun postSurvey(@RequestBody request: PostSurveyRequest): PostSurveyResponse {
        return surveyProducerService.postSurvey(request)
    }

    @GetMapping("/{surveyId}")
    fun getSurvey(@PathVariable surveyId: Long): GetSurveyResponse {
        return surveyProducerService.getSurvey(surveyId)
    }

    @GetMapping("/{surveyId}/responses")
    fun getSurveyResponse(@PathVariable surveyId: Long, request: GetSurveyRequest): List<GetSurveyResponseResponse> {
        return surveyProducerService.getSurveyResponse(surveyId)
    }

    @PatchMapping("/{surveyId}")
    fun patchSurvey(@PathVariable surveyId: Long, @RequestBody request: PatchSurveyRequest): String {
        return surveyProducerService.patchSurvey(surveyId, request)
    }

}